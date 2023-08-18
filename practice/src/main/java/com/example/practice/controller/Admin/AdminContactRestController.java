package com.example.practice.controller.Admin;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.dto.CMRespDto;
import com.example.practice.dto.ContactListRespDto;
import com.example.practice.service.ContactService;
import com.example.practice.user.User;
import com.example.practice.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminContactRestController {
   
   private final ContactService contactService;
//   private final UserRepository userRepository;
   
//   @GetMapping("/List/user")
//   public ResponseEntity<List<User>> getuserList(){
//      
//      try {
//            List<User> userList = userRepository.findAll();
//            System.out.println(userList);
//            return ResponseEntity.ok(userList);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//   }
   
   @GetMapping("/contact/list/{page}")
   public ResponseEntity<?> adminContact(@PathVariable int page) {
      List<ContactListRespDto> contactlist = null;
      try {
         contactlist = contactService.getContactList(page);
      } catch (Exception e) {
         e.printStackTrace();
         return ResponseEntity.ok().body(new CMRespDto<>(-1, page+ "page list fail to load", contactlist));
      }
      return ResponseEntity.ok().body(new CMRespDto<>(1, page+ "page list success to load", contactlist));
   }
   
   @DeleteMapping("/contact/contactDelete/{contactCode}")
   public ResponseEntity<?> deleteContact(@PathVariable int contactCode) {
      boolean status = false;
      try {
         status = contactService.removeContact(contactCode);
      } catch (Exception e) {
         e.printStackTrace();
         return ResponseEntity.ok().body(new CMRespDto<>(-1,"failed",status));
      }
      return ResponseEntity.ok().body(new CMRespDto<>(1,"success",status));
   }
   
   @GetMapping("/contact/checkContact/{contactCode}")
   public ResponseEntity<?> checkContactList(@PathVariable int contactCode) {
      List<ContactListRespDto> checkContact = null;
      try {
         checkContact = contactService.getCheckContact(contactCode);
      } catch (Exception e) {
         e.printStackTrace();
         System.out.println(checkContact + " :2 체크");
         return ResponseEntity.ok().body(new CMRespDto<>(-1, "page list fail to load", checkContact));
      }      
      return ResponseEntity.ok().body(new CMRespDto<>(1, "page list success to load", checkContact));
   }
}
