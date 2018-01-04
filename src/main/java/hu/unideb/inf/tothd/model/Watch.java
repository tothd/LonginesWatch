package hu.unideb.inf.tothd.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlValue;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@javax.xml.bind.annotation.XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@javax.xml.bind.annotation.XmlType(propOrder = { "productName", "serialNumber", "accessories", "description",
		"bracelet", "functions", "watchCase", "dialAndHands", "movement", "price" })
public class Watch {

	@XmlAttribute(required = true)
	private String uri;

	@XmlElement(required = true)
	private String productName;

	@XmlElement(required = true)
	private String serialNumber;

	@XmlElement(name = "accessories", required = false)
	private Accessories accessories;

	@XmlElement(required = false)
	private Case watchCase;

	@XmlElement(required = false)
	private String description;

	@XmlElement(required = false)
	private Bracelet bracelet;

	@XmlElement(name = "functions", required = true)
	private Functions functions;

	@XmlElement(required = false)
	private DialAndHands dialAndHands;

	@XmlElement(required = false)
	private Movement movement;

	@XmlElement(required = true)
	private Price price;

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Case getWatchCase() {
		return watchCase;
	}

	public void setWatchCase(Case watchCase) {
		this.watchCase = watchCase;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Bracelet getBracelet() {
		return bracelet;
	}

	public void setBracelet(Bracelet bracelet) {
		this.bracelet = bracelet;
	}

	public DialAndHands getDialAndHands() {
		return dialAndHands;
	}

	public void setDialAndHands(DialAndHands dialAndHands) {
		this.dialAndHands = dialAndHands;
	}

	public Movement getMovement() {
		return movement;
	}

	public void setMovement(Movement movement) {
		this.movement = movement;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public Accessories getAccessories() {
		return accessories;
	}

	public void setAccessories(Accessories accessories) {
		this.accessories = accessories;
	}

	public Functions getFunctions() {
		return functions;
	}

	public void setFunctions(Functions functions) {
		this.functions = functions;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@javax.xml.bind.annotation.XmlType(namespace = "http://www.inf.unideb.hu/Longines")
	public static class Case {

		@XmlAttribute(required = false)
		private String caseBack;

		@XmlAttribute(required = false)
		private String dimension;

		@XmlAttribute(required = false)
		private String lugDistance;

		@XmlAttribute(required = false)
		private String glass;

		@XmlAttribute(required = false)
		private String material;

		@XmlAttribute(required = false)
		private String shape;

		@XmlAttribute(required = false)
		private String waterResistance;

		public Case() {
			super();
		}

		public Case(String caseBack, String dimension, String lugDistance, String glass, String material, String shape,
				String waterResistance) {
			super();
			this.caseBack = caseBack;
			this.dimension = dimension;
			this.lugDistance = lugDistance;
			this.glass = glass;
			this.material = material;
			this.shape = shape;
			this.waterResistance = waterResistance;
		}

		public String getCaseBack() {
			return caseBack;
		}

		public void setCaseBack(String caseBack) {
			this.caseBack = caseBack;
		}

		public String getDimension() {
			return dimension;
		}

		public void setDimension(String dimension) {
			this.dimension = dimension;
		}

		public String getLugDistance() {
			return lugDistance;
		}

		public void setLugDistance(String lugDistance) {
			this.lugDistance = lugDistance;
		}

		public String getGlass() {
			return glass;
		}

		public void setGlass(String glass) {
			this.glass = glass;
		}

		public String getMaterial() {
			return material;
		}

		public void setMaterial(String material) {
			this.material = material;
		}

		public String getShape() {
			return shape;
		}

		public void setShape(String shape) {
			this.shape = shape;
		}

		public String getWaterResistance() {
			return waterResistance;
		}

		public void setWaterResistance(String waterResistance) {
			this.waterResistance = waterResistance;
		}

		public String toString() {
			return ReflectionToStringBuilder.toString(this);
		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@javax.xml.bind.annotation.XmlType(namespace = "http://www.inf.unideb.hu/Longines")
	public static class Bracelet {

		@XmlAttribute(required = false)
		private String buckle;

		@XmlAttribute(required = false)
		private String color;

		@XmlAttribute(required = false)
		private String material;

		public Bracelet() {
			super();
		}

		public Bracelet(String buckle, String color, String material) {
			super();
			this.buckle = buckle;
			this.color = color;
			this.material = material;
		}

		public String getBuckle() {
			return buckle;
		}

		public void setBuckle(String buckle) {
			this.buckle = buckle;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public String getMaterial() {
			return material;
		}

		public void setMaterial(String material) {
			this.material = material;
		}

		public String toString() {
			return ReflectionToStringBuilder.toString(this);
		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@javax.xml.bind.annotation.XmlType(namespace = "http://www.inf.unideb.hu/Longines")
	public static class DialAndHands {

		@XmlAttribute(required = false)
		private String color;

		@XmlAttribute(required = false)
		private String hourMarkers;

		@XmlAttribute(required = false)
		private String hands;

		public DialAndHands() {
			super();
		}

		public DialAndHands(String color, String hourMarkers, String hands) {
			super();
			this.color = color;
			this.hourMarkers = hourMarkers;
			this.hands = hands;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public String getHourMarkers() {
			return hourMarkers;
		}

		public void setHourMarkers(String hourMarkers) {
			this.hourMarkers = hourMarkers;
		}

		public String getHands() {
			return hands;
		}

		public void setHands(String hands) {
			this.hands = hands;
		}

		public String toString() {
			return ReflectionToStringBuilder.toString(this);
		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@javax.xml.bind.annotation.XmlType(namespace = "http://www.inf.unideb.hu/Longines")
	public static class Movement {

		@XmlValue
		private String movement;

		@XmlAttribute(required = false)
		private String indicator;

		@XmlAttribute(required = false)
		private String powerReserve;

		@XmlAttribute(required = false)
		private String caliber;

		public Movement() {
			super();
		}

		public Movement(String movement, String caliber, String indicator, String powerReserve) {
			super();
			this.movement = movement;
			this.caliber = caliber;
			this.indicator = indicator;
			this.powerReserve = powerReserve;
		}

		public String getMovement() {
			return movement;
		}

		public void setMovement(String movement) {
			this.movement = movement;
		}

		public String getCaliber() {
			return caliber;
		}

		public void setCaliber(String caliber) {
			this.caliber = caliber;
		}

		public String getIndicator() {
			return indicator;
		}

		public void setIndicator(String indicator) {
			this.indicator = indicator;
		}

		public String getPowerReserve() {
			return powerReserve;
		}

		public void setPowerReserve(String powerReserve) {
			this.powerReserve = powerReserve;
		}

		public String toString() {
			return ReflectionToStringBuilder.toString(this);
		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@javax.xml.bind.annotation.XmlType(namespace = "http://www.inf.unideb.hu/Longines")
	public static class Accessories {

		@XmlElement(name = "accessory", required = false)
		private ArrayList<String> accessories = new ArrayList<>();

		public ArrayList<String> getAccessories() {
			return accessories;
		}

		public void setAccessories(ArrayList<String> accessories) {
			this.accessories = accessories;
		}

		public Accessories() {
			super();
		}

		public Accessories(ArrayList<String> accessories) {
			super();
			this.accessories = accessories;
		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@javax.xml.bind.annotation.XmlType(namespace = "http://www.inf.unideb.hu/Longines")
	public static class Functions {

		@XmlElement(name = "function", required = false)
		private List<String> functions = new ArrayList<>();

		public List<String> getFunctions() {
			return functions;
		}

		public void setFunctions(List<String> functions) {
			this.functions = functions;
		}

		public Functions() {
			super();
		}

		public Functions(List<String> functions) {
			super();
			this.functions = functions;
		}
	}

	public static void main(String[] args) throws Exception {
		Watch watch = new Watch();
		watch.setUri(
				"http://shop.us.longines.com/watch-selector/men/the-longines-conquest-v-h-p-43mm-carbon-fiber-dial.html");

		watch.setProductName("THE LONGINES CONQUEST V.H.P. 43MM CARBON FIBER DIAL");

		watch.setSerialNumber("L37264666");

		watch.setWatchCase(new Case("Screw-down case back", "43 mm", "22 mm",
				"Sapphire with several layers of anti-reflective coating", "Stainless Steel", "Round",
				"50 meters (164 feet)"));

		Bracelet bracelet = new Bracelet();
		bracelet.setBuckle("Deployment buckle");
		bracelet.setMaterial("Stainless Steel");
		watch.setBracelet(bracelet);

		watch.setDescription(
				"The Conquest V.H.P. ensures the display of hours, minutes and seconds to an accuracy of ±5 sec/year. This extreme accuracy is achieved through an ultra-precise quartz combined with time display correction in the event of a disturbance.");

		watch.setDialAndHands(new DialAndHands("Carbon Fiber", "Applied indexes with Super-LumiNova®", "Silver hands"));

		ArrayList<String> functions = new ArrayList<>();
		functions.add("Hours, minutes seconds in the middle");
		functions.add("Date window");
		functions.add("Perpetual Calendar");
		watch.setFunctions(new Functions(functions));

		ArrayList<String> accessories = new ArrayList<>();
		accessories.add("Longines Timepiece User Manual");
		accessories.add("Watch Box");
		accessories.add("Warranty Card");
		watch.setAccessories(new Accessories(accessories));

		Movement movement = new Movement();
		movement.setMovement("Quartz");
		movement.setIndicator("yes");
		watch.setMovement(movement);

		watch.setPrice(new Price(new BigDecimal("1,050"), "USD"));
	}
}
