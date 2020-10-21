/**
 * WSFolioLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.nexura.qa_controlygestiongbt;

public class WSFolioLocator extends org.apache.axis.client.Service implements com.nexura.qa_controlygestiongbt.WSFolio {

    public WSFolioLocator() {
    }


    public WSFolioLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WSFolioLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WSFolioPort
    private java.lang.String WSFolioPort_address = "http://qa-controlygestiongbt.nexura.com/loader.php?lServicio=Asignacion&lTipo=avaluosinfonavit&lFuncion=receivedData";

    public java.lang.String getWSFolioPortAddress() {
        return WSFolioPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WSFolioPortWSDDServiceName = "WSFolioPort";

    public java.lang.String getWSFolioPortWSDDServiceName() {
        return WSFolioPortWSDDServiceName;
    }

    public void setWSFolioPortWSDDServiceName(java.lang.String name) {
        WSFolioPortWSDDServiceName = name;
    }

    public com.nexura.qa_controlygestiongbt.WSFolioPortType getWSFolioPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WSFolioPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWSFolioPort(endpoint);
    }

    public com.nexura.qa_controlygestiongbt.WSFolioPortType getWSFolioPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.nexura.qa_controlygestiongbt.WSFolioBindingStub _stub = new com.nexura.qa_controlygestiongbt.WSFolioBindingStub(portAddress, this);
            _stub.setPortName(getWSFolioPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWSFolioPortEndpointAddress(java.lang.String address) {
        WSFolioPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.nexura.qa_controlygestiongbt.WSFolioPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.nexura.qa_controlygestiongbt.WSFolioBindingStub _stub = new com.nexura.qa_controlygestiongbt.WSFolioBindingStub(new java.net.URL(WSFolioPort_address), this);
                _stub.setPortName(getWSFolioPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("WSFolioPort".equals(inputPortName)) {
            return getWSFolioPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://qa-controlygestiongbt.nexura.com", "WSFolio");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://qa-controlygestiongbt.nexura.com", "WSFolioPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WSFolioPort".equals(portName)) {
            setWSFolioPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
