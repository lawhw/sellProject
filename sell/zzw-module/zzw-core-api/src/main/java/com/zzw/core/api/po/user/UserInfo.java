package com.zzw.core.api.po.user;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.Date;

/**   
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 订单信息实体类</P>
 * @version: V1.0
 * @author: zzw
 * 
 */
@Data
public class UserInfo extends Model<UserInfo> {

	private static final long serialVersionUID = 1572352001136L;
	
	@TableId
	@ApiModelProperty(name = "userId" , value = "")
	private String userId;
    
	@ApiModelProperty(name = "username" , value = "")
	private String username;
    
	@ApiModelProperty(name = "password" , value = "")
	private String password;
    
	@ApiModelProperty(name = "openid" , value = "微信openid")
	private String openid;
    
	@ApiModelProperty(name = "role" , value = "1买家2卖家")
	private Integer role;

}
