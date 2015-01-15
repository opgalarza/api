package com.api.exception;

public class NonExistentEntityException extends GlobalException{

    /**
    *
    */
   private static final long serialVersionUID = 1L;

   /**
    * @param message
    */
   public NonExistentEntityException(String message) {
       super(404, "405", message);
   }

   /**
    * 
    * @param message
    * @param cause
    */
   public NonExistentEntityException(String message, Throwable cause) {
       super(404, "405", message, cause);
   }	
}