/*
 * Copyright (C) 2014 Trillian Mobile AB.
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
package org.robovm.gradle;

import org.gradle.api.Project;

/**
 *
 * @author Junji Takakura
 */
public class RoboVMPluginExtension {

    public static final String NAME = "robovm";
    private final Project project;
    private String propertiesFile;
    private String configFile;
    private String iosSignIdentity;
    private String iosProvisioningProfile;
    private String iosSimulatorSdk;
    private String stdoutFifo;
    private String stderrFifo;
    private String os;
    private String arch;
    private boolean iosSkipSigning = false;

    public RoboVMPluginExtension(Project project) {
        this.project = project;
    }

    public Project getProject() {
        return project;
    }

    public String getPropertiesFile() {
        return propertiesFile;
    }

    public void setPropertiesFile(String propertiesFile) {
        this.propertiesFile = propertiesFile;
    }

    public String getConfigFile() {
        return configFile;
    }

    public void setConfigFile(String configFile) {
        this.configFile = configFile;
    }

    public String getIosSignIdentity() {
        return iosSignIdentity;
    }

    public void setIosSignIdentity(String iosSignIdentity) {
        this.iosSignIdentity = iosSignIdentity;
    }

    public String getIosProvisioningProfile() {
        return iosProvisioningProfile;
    }

    public void setIosProvisioningProfile(String iosProvisioningProfile) {
        this.iosProvisioningProfile = iosProvisioningProfile;
    }

    public String getIosSimulatorSdk() {
        return iosSimulatorSdk;
    }

    public void setIosSimulatorSdk(String iosSimulatorSdk) {
        this.iosSimulatorSdk = iosSimulatorSdk;
    }

    public String getStdoutFifo() {
        return stdoutFifo;
    }

    public void setStdoutFifo(String stdoutFifo) {
        this.stdoutFifo = stdoutFifo;
    }

    public String getStderrFifo() {
        return stderrFifo;
    }

    public void setStderrFifo(String stderrFifo) {
        this.stderrFifo = stderrFifo;
    }

    public boolean isIosSkipSigning() {
        return iosSkipSigning;
    }

    public void setIosSkipSigning(boolean iosSkipSigning) {
        this.iosSkipSigning = iosSkipSigning;
    }

    public String getOs() {
        return project.hasProperty("robovm.os") ? project.getProperties().get("robovm.os").toString() : os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getArch() {
        return project.hasProperty("robovm.arch") ? project.getProperties().get("robovm.arch").toString() : arch;
    }

    public void setArch(String arch) {
        this.arch = arch;
    }
}
