package hello.springmvc.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Order {
	private Long memberId;
	private String itemName;
	private int itemPirce;
	private int discountPrice;
	
	public int calculatePrice() {
		return itemPirce - discountPrice;
	}
}
