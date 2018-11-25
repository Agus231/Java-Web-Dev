package edu.epam.xml.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SessionRequestContent {
    private Map<String, Object> requestAttributes;
    private Map<String, String[]> requestParameter;
    private HashMap<String, Object> sessionAttributes;

    public void extractValues(HttpServletRequest request) {
        requestAttributes = new HashMap<>();

        Enumeration<String> attributeNames = request.getAttributeNames();
        while (attributeNames.hasMoreElements()){
            String name = attributeNames.nextElement();
            Object value = request.getAttribute(name);

            requestAttributes.put(name, value);
        }

        requestParameter = request.getParameterMap();
        sessionAttributes = new HashMap<>();

        HttpSession session = request.getSession();
        Enumeration<String> sessionAttributeNames = session.getAttributeNames();
        while (sessionAttributeNames.hasMoreElements()){
            String name = sessionAttributeNames.nextElement();
            Object value = session.getAttribute(name);

            sessionAttributes.put(name, value);
        }
    }

    public void importValues(HttpServletRequest request){
        Set<Map.Entry<String, Object>> attributeEntrySet = requestAttributes.entrySet();

        for (Map.Entry<String, Object> entry: attributeEntrySet) {
            request.setAttribute(entry.getKey(), entry.getValue());
        }

        HttpSession session = request.getSession();
        Set<Map.Entry<String, Object>> sessionAttributeEntrySet = sessionAttributes.entrySet();

        for (Map.Entry<String, Object> entry: sessionAttributeEntrySet) {
            session.setAttribute(entry.getKey(), entry.getValue());
        }

    }

    public String getParameter(String key) { return requestParameter.get(key)[0]; }

    public Object getAttribute(String key) { return requestAttributes.get(key); }

    public void setAttribute(String key, Object value){
        requestAttributes.put(key, value);
    }

    public Object getSessionAttribute(String key) { return sessionAttributes.get(key); }

    public void setSessionAttribute(String key, Object value) { sessionAttributes.put(key, value); }
}
