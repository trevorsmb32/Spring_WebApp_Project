package com.emusicstore.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.emusicstore.daoImpl.ProductDaoImpl;
import com.emusicstore.daoImpl.userDaoImpl;
import com.emusicstore.pojo.Admin;
import com.emusicstore.pojo.Product;
import com.emusicstore.service.ProductService;
import com.models.Login_Model;

@Controller
public class adminController {

	
	@Autowired
	ProductService productService;
	
	Path path;
	Logger logger = Logger.getLogger(adminController.class);

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView loginPageLoad(){

		ModelAndView mav = new ModelAndView("login");
		Admin admin = new Admin();
		mav.addObject("admin",admin);

		return mav;
	}


	//Used to submit user details
	@RequestMapping(value="/login" , method=RequestMethod.POST)
	public String login_commit(HttpServletRequest req, Model mod,HttpSession session, @Valid Admin admin, BindingResult br){

		try{
			
			logger.info("You are in /login controller");
			String username = req.getParameter("username");
			String password = req.getParameter("password");

			//System.out.println(br.getAllErrors());
			//System.out.println("Login attempt");

			userDaoImpl authenticate = new userDaoImpl();
			String message = authenticate.doHibernateLogin(username, password);
			//.equals is used to compare objects			
			if (message.equals("login success")){
				session.setAttribute("username", username);
				return "redirect:admin";
			}
			else{
				//Print Error Message
				System.out.println("Login Failed");
				//mod.addAttribute("error_msg",message);
			}

			return "login";
		}

		catch(Exception e){


			return "login";
		}

	}

	@RequestMapping(value="admin",method=RequestMethod.GET)
	public ModelAndView profileLogin(HttpSession session, Model mod){

		ModelAndView mav = new ModelAndView("admin");
		String username = session.getAttribute("username").toString();
		mod.addAttribute("user",username);

		return mav;

	}	

	@RequestMapping(value="admin/productInventory",method=RequestMethod.GET)
	public String productList2(Model model){

		List<Product> products = productService.getProductList();
		model.addAttribute("products", products);

		return "productInventory";
	}


	@RequestMapping(value="admin/productInventory/deleteProduct/{id}",method=RequestMethod.GET)	
	public String deleteProduct(@PathVariable("id")int id){
		
		logger.info("Attempting to delete id"+id);
		productService.deleteProduct(id);	

		return "redirect:/admin/productInventory";

	}

	@RequestMapping(value="/admin/productInventory/addProduct",method=RequestMethod.POST)
	public String addProduct(@Valid@ModelAttribute("product") Product product, MultipartFile file, BindingResult br,HttpServletRequest request){

		logger.debug("Binding Result Debug add Prodcut:"+br.getAllErrors());
		productService.addProduct(product);	

		MultipartFile productImage = product.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory+"\\WEB-INF\\resource\\images\\"+product.getId()+".png");
		logger.info("Saving to path: "+path);

		try {
			productImage.transferTo(new File(path.toString()));
			logger.info("attempting to save");
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("image did not save");
			throw new RuntimeException("Product image saving failed.", e);
		}


		return "redirect:/admin/productInventory";
	}


	@RequestMapping(value="/admin/productInventory/addProduct",method=RequestMethod.GET)
	public ModelAndView addProducts(){

		ModelAndView mav = new ModelAndView("addProduct");
		Product product = new Product();
		mav.addObject("product",product);

		return mav;
	}

	@RequestMapping(value="productList/viewProduct/{id}",method=RequestMethod.GET)
	public String viewProduct(@PathVariable("id")int id,Model model){

		Product product = productService.getProductById(id);
		model.addAttribute("product", product);

		return "viewProduct";

	}

	@RequestMapping(value="admin/productInventory/editProduct/{id}",method=RequestMethod.GET)
	public String editProduct(@PathVariable("id")int id,Model model){

		Product product =productService.getProductById(id);
		model.addAttribute("product", product);

		return "editProduct";

	}

	@RequestMapping(value="/admin/productInventory/editProduct/{id}",method=RequestMethod.POST)
	public String editProduct(@Valid@ModelAttribute("product")Product product,@PathVariable("id") int id,BindingResult br, Model model){
		
		logger.info("Attempting edit"+id);
		if(br.hasErrors()){
			return "editProduct";
		}
		
		logger.debug("Newly editing"+id);
		productService.editProduct(id);


		return "redirect:/admin/productInventory";

	}

	@RequestMapping(value = "/time", produces = MediaType.TEXT_PLAIN_VALUE)
	public String handler(HttpSession httpSession) {
		String sessionKey = "firstAccessTime";
		Object time = httpSession.getAttribute(sessionKey);
		if (time == null) {
			time = LocalDateTime.now();
			httpSession.setAttribute(sessionKey, time);
		}
		return "first access time : " + time+"\nsession id: "+httpSession.getId();
	}
}



