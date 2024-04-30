package com.blog.ApiResponse;

import com.blog.DTO.UserDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {
    private boolean success;
    private String message;
    private UserDTO user;

    public ApiResponse(boolean success,String message){
        this.success=success;
        this.message=message;
    }
// See ResponseEntity entity constructors... take eg how they have implimented diff. constructors.
// constructor overriding not allowed.

    public ApiResponse(boolean success, String message ,UserDTO user){
        this.success=success;
        this.message=message;
        this.user=user;

    }


}
