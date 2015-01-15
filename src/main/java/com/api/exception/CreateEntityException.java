package com.api.exception;

public class CreateEntityException extends GlobalException{

    /**
    *
    */
   private static final long serialVersionUID = 1L;

   /**
    *
    */
   public CreateEntityException(String message) {
       super(409, "40905", message);
   }

   public CreateEntityException(String message, Throwable cause) {
       super(409, "40905", message, cause);
   }
}
