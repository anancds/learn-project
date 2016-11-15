/**
 * Copyright (c) 2016, zhejiang Unview Technologies Co., Ltd.
 * All rights reserved.
 * <http://www.uniview.com/>
 * -----------------------------------------------------------
 * Product      :BigData
 * Module Name  :
 * Project Name :learn-project
 * Package Name :com.cds.jni
 * Date Created :2016/11/15
 * Creator      :c02132
 * Description  :
 * -----------------------------------------------------------
 * Modification History
 * Date        Name          Description
 * ------------------------------------------------------------
 * 2016/11/15      c02132         BigData project,new code file.
 * ------------------------------------------------------------
 */
package com.cds.jni;

import com.sun.jna.Library;

public interface JniFunction extends Library{


    float st_score_standard(float score);
}
