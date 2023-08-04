package com.example.practice.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Qna {

	private int qna_code;
	private int user_code;
	private int content_code;
	private String qna_title;
	private String qna_content;
	private int state_code;
	private int option_select_code;
	private int option_all_code;
}
