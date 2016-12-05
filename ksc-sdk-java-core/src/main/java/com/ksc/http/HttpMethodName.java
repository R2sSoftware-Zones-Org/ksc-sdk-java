/*
 * Copyright 2010-2016 ksyun.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 * 
 *  http://ksyun.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.ksc.http;

import com.ksc.util.StringUtils;

public enum HttpMethodName {

    GET,
    POST,
    PUT,
    DELETE,
    HEAD,
    PATCH;

    /**
     * @param value Raw string representing value of enum
     * @return HttpMethodName enum or null if value is not present.
     * @throws IllegalArgumentException If value does not represent a known enum value.
     */
    public static HttpMethodName fromValue(String value) {
        if (StringUtils.isNullOrEmpty(value)) {
            return null;
        }

        final String upperCaseValue = StringUtils.upperCase(value);
        for (HttpMethodName httpMethodName : values()) {
            if (httpMethodName.name().equals(upperCaseValue)) {
                return httpMethodName;
            }
        }
        throw new IllegalArgumentException("Unsupported HTTP method name " + value);
    }

}