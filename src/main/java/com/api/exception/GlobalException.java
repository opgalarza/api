package com.api.exception;



public class GlobalException extends Exception{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
    *
    */
   private final int status;

   /**
    *
    */
   private String errorMessage;

   /**
    *
    */
   private final String errorCode;

   /**
    * @param httpStatus
    * @param errorCode
    * @param errorMessage
    */
   public GlobalException(int httpStatus, String errorCode, String errorMessage) {
       super(errorMessage);
       this.status = httpStatus;
       this.errorCode = errorCode;
       this.errorMessage = errorMessage;
   }

   public GlobalException(int httpStatus, String errorCode, String errorMessage, Throwable cause) {
       super(errorMessage, cause);
       this.status = httpStatus;
       this.errorCode = errorCode;
       this.errorMessage = errorMessage;
   }

   /**
    * @return
    */
   public int getStatus() {
       return status;
   }

   /**
    * @return
    */
   public String getErrorMessage() {
       return errorMessage;
   }

   /**
    * @return
    */
   public String getErrorCode() {
       return errorCode;
   }

   /**
    * @param errorMessage
    */
   public void setErrorMessage(String errorMessage) {
       this.errorMessage = errorMessage;
   }
}