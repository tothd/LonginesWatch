package hu.unideb.inf.tothd.parser;

import hu.unideb.inf.tothd.model.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WatchParser {

    private static final String currency = "USD";
    private static Logger logger = LoggerFactory.getLogger(WatchParser.class);

    public WatchParser() {
    }

    public Watch parse(String url) throws IOException {
        Document doc = Jsoup.connect(url).userAgent("Mozilla").get();
        Watch watch = parse(doc);
        watch.setUri(url);
        return watch;
    }

    public Watch parse(File file) throws IOException {
        Document doc = Jsoup.parse(file, null);
        Watch watch = parse(doc);
        watch.setUri(file.toURI().toString());
        return watch;
    }

    public Watch parse(Document doc) throws IOException {
        Watch watch = new Watch();

        // Get product name
        watch.setProductName(doc.select("div.product-name > h1").text());

        // Get serial number
        watch.setSerialNumber(doc.select("div.sku").first().text());

        // Get accessories
        ArrayList<String> accessories = new ArrayList<>();
        for (Element e : doc.select("div.information > ul > li > ul > li")) {
            accessories.add(e.text());
        }
        watch.setAccessories(new Accessories(accessories));

        // Get description
        watch.setDescription(doc.select("div.product-description").first().text());

        // Get bracelet
        Bracelet bracelet = new Bracelet();
        for (Element e : doc.select("div.bracelet > ul > li")) {
            Elements siblings = e.children();
            String title = siblings.get(0).text();
            String value = siblings.get(1).text();

            switch (title) {
                case "Bracelet Buckle":
                    bracelet.setBuckle(value);
                    break;
                case "Bracelet Color":
                    bracelet.setColor(value);
                    break;
                case "Bracelet Material":
                    bracelet.setMaterial(value);
                    break;
            }
        }
        watch.setBracelet(bracelet);

        // Get functions
        List<String> functions = Arrays.asList(doc.select("div.functions > ul > li").last().text()
                .replace("Main Functions ", "").replace(".", ", ").toLowerCase().split(", "));
        watch.setFunctions(new Functions(functions));

        // Get watch case
        Case watchCase = new Case();
        for (Element e : doc.select("div.case > ul > li")) {
            Elements siblings = e.children();
            String title = siblings.get(0).text();
            String value = siblings.get(1).text();

            switch (title) {
                case "Case Back":
                    watchCase.setCaseBack(value);
                    break;
                case "Dimension":
                    watchCase.setDimension(value);
                    break;
                case "Lug Distance":
                    watchCase.setLugDistance(value);
                    break;
                case "Glass":
                    watchCase.setGlass(value);
                    break;
                case "Material":
                    watchCase.setMaterial(value);
                    break;
                case "Shape":
                    watchCase.setShape(value);
                    break;
                case "Water Resistance":
                    watchCase.setWaterResistance(value);
                    break;
            }
        }
        watch.setWatchCase(watchCase);

        // Get dial and hands
        DialAndHands dialAndHands = new DialAndHands();
        for (Element e : doc.select("div.dial-and-hands > ul > li")) {
            Elements siblings = e.children();
            String title = siblings.get(0).text();
            String value = siblings.get(1).text();

            switch (title) {
                case "Color":
                    dialAndHands.setColor(value);
                    break;
                case "Hour Markers":
                    dialAndHands.setHourMarkers(value);
                    break;
                case "Hands":
                    dialAndHands.setHands(value);
                    break;
            }
        }
        watch.setDialAndHands(dialAndHands);

        // Get movement
        Movement movement = new Movement();
        for (Element e : doc.select("div.movement > ul > li")) {
            Elements siblings = e.children();
            String title = siblings.get(0).text();
            String value = siblings.get(1).text();

            switch (title) {
                case "E.O.L. Indicator":
                    movement.setIndicator(value);
                    break;
                case "Movement":
                    movement.setMovement(value);
                    break;
                case "Power Reserve":
                    movement.setPowerReserve(value);
                    break;
                case "Caliber":
                    movement.setCaliber(value);
            }
        }
        watch.setMovement(movement);

        // Get price
        Element p = doc.select("div.price-box > span.regular-price > span.price").first();
        watch.setPrice(new Price(new BigDecimal(p.text().replaceAll("[^\\d.-]", "")), currency));

        return watch;
    }
}