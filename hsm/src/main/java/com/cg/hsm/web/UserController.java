package com.cg.hsm.web;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hsm.domain.User;
import com.cg.hsm.service.MapValidationErrorService;
import com.cg.hsm.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController 
{
   @Autowired
   private UserService userService;
   
   @Autowired
   private MapValidationErrorService mapValidationErrorService;
   
   @PostMapping("")
   public ResponseEntity<?> createUser(@Valid @RequestBody User user,BindingResult result)
   {
	   ResponseEntity<?> errorMap=mapValidationErrorService.mapValidationError(result);
	   if(errorMap != null)
		   return errorMap;
	   User us= userService.saveOrUpdate(user);
	   return new ResponseEntity<User>(us,HttpStatus.OK);
   }
   
   @GetMapping("/{userName}")
   public ResponseEntity<?> getUserByUserName(@PathVariable String userName)
   {
	  User user = userService.findByUserName(userName);
	  return new ResponseEntity<User>(user,HttpStatus.OK);
   }
   
   @GetMapping("/all")
   public Iterable<User> getAllUsers()
   {
	   return userService.getAllUsers();
   }
   
   @DeleteMapping("/{userName}")
   public ResponseEntity<?> deleteUser(@PathVariable String userName)
   {
	   userService.deleteByUserName(userName);
	   return new ResponseEntity<String>("User having : "+userName+" got deleted",HttpStatus.OK);
   }
}
