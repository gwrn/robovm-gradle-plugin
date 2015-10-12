/*
 * Copyright (C) 2014 RoboVM AB.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.robovm.gradle.tasks;

import java.lang.reflect.Method;

import org.gradle.api.DefaultTask;
import org.gradle.api.GradleException;
import org.gradle.api.tasks.TaskAction;
import org.robovm.gradle.RoboVMPluginExtension;

public class ActivateLicenseTask extends DefaultTask {
    @TaskAction
    public void activateLicense() {
        String licenseKey = ((RoboVMPluginExtension)getProject().getExtensions().getByName(RoboVMPluginExtension.NAME)).getLicenseKey();
        
        if (licenseKey == null) {
            throw new GradleException("Provide a license key to activate via -Probovm.licenseKey=<your-key>");
        }

        try {
            Class clazz = ActivateLicenseTask.class.getClassLoader().loadClass("com.robovm.lm.LicenseManager");
            Method m = clazz.getMethod("main", String[].class);
            String[] args = { "activate", licenseKey };
            m.invoke(null, new Object[] { args });            
        } catch (Throwable e) {
            throw new GradleException("Couldn't activate license", e);
        }
    }
}
