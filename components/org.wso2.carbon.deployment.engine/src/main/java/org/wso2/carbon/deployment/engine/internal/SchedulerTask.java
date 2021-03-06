/*
 *  Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.wso2.carbon.deployment.engine.internal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Scheduler Task which gets called periodically by the executor service and
 * calls the repository scanner internally.
 *
 * @since 5.0.0
 */
public class SchedulerTask implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(SchedulerTask.class);

    private RepositoryScanner repositoryScanner;

    /**
     * This will construct the SchedulerTask with the given RepositoryScanner instance.
     *
     * @param repositoryScanner the repositoryScanner instance to be used with each task run
     */
    public SchedulerTask(RepositoryScanner repositoryScanner) {
        this.repositoryScanner = repositoryScanner;
    }

    public void run() {
        try {
            repositoryScanner.scan();
        } catch (Throwable e) {
            logger.error("Error occurred while scanning deployment repository", e);
        }
    }
}
