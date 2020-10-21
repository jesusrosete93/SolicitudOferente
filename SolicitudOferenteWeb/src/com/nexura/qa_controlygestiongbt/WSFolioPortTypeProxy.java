package com.nexura.qa_controlygestiongbt;

public class WSFolioPortTypeProxy implements com.nexura.qa_controlygestiongbt.WSFolioPortType {
  private String _endpoint = null;
  private com.nexura.qa_controlygestiongbt.WSFolioPortType wSFolioPortType = null;
  
  public WSFolioPortTypeProxy() {
    _initWSFolioPortTypeProxy();
  }
  
  public WSFolioPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initWSFolioPortTypeProxy();
  }
  
  private void _initWSFolioPortTypeProxy() {
    try {
      wSFolioPortType = (new com.nexura.qa_controlygestiongbt.WSFolioLocator()).getWSFolioPort();
      if (wSFolioPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wSFolioPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wSFolioPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wSFolioPortType != null)
      ((javax.xml.rpc.Stub)wSFolioPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.nexura.qa_controlygestiongbt.WSFolioPortType getWSFolioPortType() {
    if (wSFolioPortType == null)
      _initWSFolioPortTypeProxy();
    return wSFolioPortType;
  }
  
  public void gstServicesInfonavitValidation(java.lang.String validacion, java.lang.String data, javax.xml.rpc.holders.IntHolder code, javax.xml.rpc.holders.StringHolder message) throws java.rmi.RemoteException{
    if (wSFolioPortType == null)
      _initWSFolioPortTypeProxy();
    wSFolioPortType.gstServicesInfonavitValidation(validacion, data, code, message);
  }
  
  
}