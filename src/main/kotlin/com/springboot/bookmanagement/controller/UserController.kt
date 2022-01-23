package com.springboot.bookmanagement.controller

import com.springboot.bookmanagement.repository.entity.User
import com.springboot.bookmanagement.service.impl.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class UserController(private val userService: UserService) {

    @PostMapping("/signup")
    fun register(@RequestBody userCreateRequest: User): User = userService.register(userCreateRequest)

    @RequestMapping(method = [RequestMethod.POST], path = ["/login"])
    @PostMapping("/login")
    fun login(): ResponseEntity<String> {
        return ResponseEntity.ok("")
    }
}