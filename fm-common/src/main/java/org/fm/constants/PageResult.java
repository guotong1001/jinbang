package org.fm.constants;


import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.fm.view.GlobleView;

import java.io.Serializable;
import java.util.List;


/**
 * 分页实体类
 * total 总数
 * code  是否成功
 * data 当前页结果集
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> implements Serializable {

	private static final long serialVersionUID = -275582248840137389L;

	@JsonView(GlobleView.class)
	private Long count;
	@JsonView(GlobleView.class)
	private int code;
	@JsonView(GlobleView.class)
	private List<T> data;

}
