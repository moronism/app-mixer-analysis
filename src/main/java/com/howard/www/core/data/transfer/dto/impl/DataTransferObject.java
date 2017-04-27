package com.howard.www.core.data.transfer.dto.impl;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.http.HttpServletRequest;

import com.howard.www.core.data.transfer.dto.IDataTransferObject;
import com.howard.www.core.util.MapObjectDepthClone;
import com.howard.www.core.web.util.FrameworkStringUtil;
import com.howard.www.core.web.util.RequestHelper;

public class DataTransferObject implements IDataTransferObject, Serializable {

	private static final long serialVersionUID = -6324290676125314610L;

	private static final String SQLSTATEMENT = "sqlStatement";

	private static final String PRIMITIVESQLSTATEMENT = "primitiveSqlStatement";

	private static final String PRIMITIVESQLNAME = "primitiveSqlName";

	private static final String REQUESTPARAMS = "requestParams";

	private static final String PARAMOFENTITYNAME = "paramOfEntityName";

	private static final String INTERACTIVEDATA = "interactiveData";

	private static final String REQUIREDPARAMETER = "requiredParameter";

	private static final String RESULTSET = "resultSet";
	/**
	 * dataTransferObject
	 */
	private ConcurrentHashMap<String, Object> dataTransferObject;

	public ConcurrentHashMap<String, Object> getDataTransferObject() {
		return dataTransferObject;
	}

	public void setDataTransferObject(
			ConcurrentHashMap<String, Object> dataTransferObject) {
		this.dataTransferObject = dataTransferObject;
	}

	public DataTransferObject() {
		dataTransferObject = new ConcurrentHashMap<String, Object>();
	}

	/**
     * 
     */
	@SuppressWarnings("unchecked")
	public ConcurrentHashMap<String, Object> obtainRequestParamsMap() {
		return (ConcurrentHashMap<String, Object>) dataTransferObject
				.get(REQUESTPARAMS);
	}

	/**
     * 
     */
	public void evaluateRequestParamsMap(
			ConcurrentHashMap<String, Object> paramsOfRequestMap) {
		if (paramsOfRequestMap != null) {
			dataTransferObject.put(REQUESTPARAMS, paramsOfRequestMap);
		}
	}

	/**
     * 
     */
	public void evaluateRequestParams(HttpServletRequest request) {
		ConcurrentHashMap<String, Object> paramsOfRequestMap = RequestHelper
				.conversionRequestParameter(request);
		ConcurrentHashMap<String, Object> mapOfRequiredParameter = null;
		try {
			mapOfRequiredParameter = MapObjectDepthClone
					.mapDeepCopy(paramsOfRequestMap);
		} catch (Exception e) {

		}
		if (mapOfRequiredParameter != null) {
			this.evaluteRequiredParameter(mapOfRequiredParameter);
		}
		this.evaluateRequestParamsMap(paramsOfRequestMap);
	}

	/**
	 * 
	 */
	public void evaluateSqlStatement(String sqlStatement) {
		if (FrameworkStringUtil.isNullOfString(sqlStatement) == false) {
			dataTransferObject.put(SQLSTATEMENT, sqlStatement);
		}
	}

	/**
	 * 
	 */
	public void evaluatePrimitiveSqlStatement(String primitiveSqlStatement) {
		if (FrameworkStringUtil.isNullOfString(primitiveSqlStatement) == false) {
			dataTransferObject
					.put(PRIMITIVESQLSTATEMENT, primitiveSqlStatement);
		}
	}

	/**
     * 
     */
	public void evaluatePrimitiveSqlName(String sqlName) {
		if (FrameworkStringUtil.isNullOfString(sqlName) == false) {
			dataTransferObject.put(PRIMITIVESQLNAME, sqlName);
		}
	}

	/**
     * 
     */
	public String obtainSqlStatement() {
		return FrameworkStringUtil.asString(dataTransferObject
				.get(SQLSTATEMENT));
	}

	/**
     * 
     */
	public String obtainPrimitiveSqlStatement() {
		return FrameworkStringUtil.asString(dataTransferObject
				.get(PRIMITIVESQLSTATEMENT));
	}

	/**
     * 
     */
	public String obtainPrimitiveSqlName() {
		return FrameworkStringUtil.asString(dataTransferObject
				.get(PRIMITIVESQLNAME));
	}

	/**
     * 
     */
	public void evaluateEntityName(String paramOfEntityName) {
		if (FrameworkStringUtil.isNullOfString(paramOfEntityName) == false) {
			dataTransferObject.put(PARAMOFENTITYNAME, paramOfEntityName);
		}
	}

	/**
     * 
     */
	public String obtainEntityName() {
		return FrameworkStringUtil.asString(dataTransferObject
				.get(PARAMOFENTITYNAME));
	}

	/**
     * 
     */
	public void evaluateInteractiveData(Object paramOfInteractiveData) {
		if (paramOfInteractiveData != null) {
			dataTransferObject.put(INTERACTIVEDATA, paramOfInteractiveData);
		}
	}

	/**
     * 
     */
	public Object obtainInteractiveData() {
		return dataTransferObject.get(INTERACTIVEDATA);
	}

	/**
     * 
     */
	public ConcurrentHashMap<String, Object> evaluteRequiredParameter(
			ConcurrentHashMap<String, Object> mapOfRequiredParameter) {
		if (mapOfRequiredParameter == null) {
			mapOfRequiredParameter = new ConcurrentHashMap<String, Object>();
		}
		dataTransferObject.put(REQUIREDPARAMETER, mapOfRequiredParameter);
		return mapOfRequiredParameter;
	}

	/**
     * 
     */
	public ConcurrentHashMap<String, Object> evaluteRequiredParameter(
			String keyOfParameter, Object valueOfParameter) {
		ConcurrentHashMap<String, Object> mapOfRequiredParameter = obtainMapOfRequiredParameter();
		if (mapOfRequiredParameter != null) {

		} else {
			mapOfRequiredParameter = evaluteRequiredParameter(null);
		}
		mapOfRequiredParameter.put(keyOfParameter, valueOfParameter);
		return mapOfRequiredParameter;
	}

	/**
     * 
     */
	@SuppressWarnings("unchecked")
	public ConcurrentHashMap<String, Object> obtainMapOfRequiredParameter() {
		if (dataTransferObject != null) {
			if (dataTransferObject.get(REQUIREDPARAMETER) == null) {
				return null;
			}
			return (ConcurrentHashMap<String, Object>) dataTransferObject
					.get(REQUIREDPARAMETER);
		} else {
			return null;
		}

	}

	public IDataTransferObject generateDataTransferObject() {

		return this;
	}

	public IDataTransferObject evaluateResultSet(Object resultSet) {
		dataTransferObject.put(RESULTSET, resultSet);
		return generateDataTransferObject();
	}

	public Object obtainResultSet() {
		return dataTransferObject.get(RESULTSET);
	}

	@Override
	public IDataTransferObject generateDataTransferObject(
			IDataTransferObject queryParameters) {
		// TODO Auto-generated method stub
		return null;
	}

}
