package web.scrapper.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import web.scrapper.resources.models.Entity;

public class FilterUrlAndSelectors {

	/**
	 * Gives the filtered output based on the
	 */
	public Map<String, Object> getFilteredEntity(Document document, Entity entity) {
		Map<String, Object> map = new HashMap<>();
		executeQuerySelectors(map, document, entity);
		return map;
	}

	/**
	 * parses the given config(entity) and updates the values in the output map.
	 */
	private void executeQuerySelectors(Map<String, Object> map, Node document, Entity entity) {
		List<Entity> entityScrappers = entity.getEntityScrapers();
		if (isEmpty(entityScrappers)) {
			Object obj = applySelector(document, entity.getSelector());
			map.put(entity.getEntity(), obj);
		} else {
			Map<String, Object> childMap = new HashMap<>();
			Node filteredDocument = applySelectorAsDocument(document, entity.getSelector());
			for (Entity entityScrapper : entityScrappers) {
				executeQuerySelectors(childMap, filteredDocument == null ? document : filteredDocument, entityScrapper);
				map.put(entity.getEntity(), childMap);
			}
		}
	}

	/**
	 * Applies the selector(one level) on the given document and returns the result.
	 */
	private Node applySelectorAsDocument(Node document, String selector) {

		if (document instanceof Document) {
			Document doc = (Document) document;
			if ("head".equals(selector)) {
				return doc.head();
			} else if ("body".equals(selector)) {
				return doc.body();
			}
		}
		return document;
	}

	/**
	 * Splits the selector and
	 */
	private Object applySelector(Node document, String selector) {
		// filter the className, selector and attribute and store it in finalId,
		// finalSelector and split[1].
		String finalId = null;
		String finalSelector = null;
		String[] split = selector.split("::");
		if (split.length == 2) {
			String[] selectorSplit = split[0].split(" ");
			if (selectorSplit.length == 2) {
				finalSelector = selectorSplit[1];
			}
			finalId = selectorSplit[0];
		}

		// First level of filtering based on the className or id of CSS.
		Elements elements = new Elements(new ArrayList<>());
		boolean isElement = true;
		if (!isEmpty(finalId) && finalId.length() > 1) {
			if (document instanceof Document) {
				Document doc = (Document) document;
				elements.addAll(doc.getElementsByClass(finalId.substring(1)));
				isElement = false;
			} else if (document instanceof Element) {
				Element element = (Element) document;
				elements.addAll(element.getElementsByClass(finalId.substring(1)));
			}
		}

		// Second level of filtering based on the type of css selector given.
		List<Element> finalElements = new ArrayList<>();
		if (!isEmpty(finalSelector)) {
			for (Element finalElement : elements) {
				Elements filteredElementAfterTag = finalElement.getElementsByTag(finalSelector);
				finalElements.addAll(filteredElementAfterTag);
			}
		} else {
			finalElements.addAll(elements);
		}

		// Third level of filtering based on the attribute values.
		String attribute = split[1];
		List<Object> list = new ArrayList<>();
		if (!isEmpty(finalElements)) {
			for (Element current : finalElements) {
				Object data = extractAttribute(current, attribute);
				list.add(data);
			}
		} else {
			if (isElement) {
				Element element = (Element) document;
				Object data = extractAttribute(element, attribute);
				list.add(data);
			}
		}

		return list.size() > 1 ? list : list.get(0);
	}

	/**
	 * Checks the type of attribute given and iterates all the child nodes based on
	 * the type of attribute given and returns its value. Accepted attributes:
	 * attr(<str>), text, text(<len>), str(<str>), len().
	 */
	private Object extractAttribute(Element current, String attribute) {
		if (attribute.startsWith("attr(")) {
			String attr = attribute.substring(5, attribute.length() - 1);
			Attributes attributes = current.attributes();
			for (Attribute currentAttribute : attributes) {
				if (attr.equals(currentAttribute.getKey())) {
					return currentAttribute.getValue();
				}
			}
		} else if (attribute.startsWith("text(")) {
			int length = Integer.parseInt(attribute.substring(0, attribute.length() - 1));
			List<Node> list = current.childNodes();
			if (!isEmpty(list)) {
				return list.get(0).toString().substring(0, length);
			}
		} else if (attribute.startsWith("text")) {
			List<Node> list = current.childNodes();
			if (!isEmpty(list)) {
				return list.get(0).toString();
			}
		} else if (attribute.startsWith("str(")) {
			return attribute.substring(4, attribute.length() - 2);
		} else {
			return Integer.parseInt(attribute.substring(4, attribute.length() - 1));
		}
		return "";
	}

	private boolean isEmpty(String string) {
		return null == string || string.length() == 0;
	}

	private boolean isEmpty(List<? extends Object> collection) {
		return null == collection || collection.isEmpty();
	}

}
