/**
 *
 *
 * https://www.leimingtech.com
 *
 * 版权所有，侵权必究！
 */

package org.wiulus.spring.cloud.commons.tools.security.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.wiulus.spring.cloud.commons.tools.utils.TreeNode;
import org.wiulus.spring.cloud.commons.tools.validator.group.AddGroup;
import org.wiulus.spring.cloud.commons.tools.validator.group.DefaultGroup;
import org.wiulus.spring.cloud.commons.tools.validator.group.UpdateGroup;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;

/**
 * 菜单管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0
 */
@ApiModel(value = "商家菜单管理")
@Date
public class StoreMenuDTOs extends TreeNode<StoreMenuDTOs> implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	@Null(message="{id.null}", groups = AddGroup.class)
	@NotNull(message="{id.require}", groups = UpdateGroup.class)
	private Long id;

	@ApiModelProperty(value = "上级ID")
	@NotNull(message="{sysmenu.pid.require}", groups = DefaultGroup.class)
	private Long pid;

	@ApiModelProperty(value = "菜单名称")
	@NotBlank(message="{sysmenu.name.require}", groups = DefaultGroup.class)
	private String name;

	@ApiModelProperty(value = "菜单URL")
	private String url;

	@ApiModelProperty(value = "类型  0：菜单   1：按钮")
	@Range(min=0, max=1, message = "{sysmenu.type.range}", groups = DefaultGroup.class)
	private Integer type;

	@ApiModelProperty(value = "菜单图标")
	private String icon;

	@ApiModelProperty(value = "权限标识，如：sys:menu:save")
	private String permission;

	@ApiModelProperty(value = "排序")
	@Min(value = 0, message = "{sort.number}", groups = DefaultGroup.class)
	private Integer sort;
}
