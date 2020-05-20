/**
 * 
 */
package com.jesushenriquez.demo.resource.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author jesushenriquez
 *
 */
@Data
public class UserVO {
	
	private String email;
	private String username;
	private String password;

}
