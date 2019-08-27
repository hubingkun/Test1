package com.cy.pj.sys.entity;
import java.io.Serializable;

import lombok.Data;
@Data
public class SysUser implements Serializable{
	private static final long serialVersionUID = 6600959245196375023L;
	private Integer id;
	private String name;
	private String password;
	private String salt;
	private String email;
	private String mobile;
}
 