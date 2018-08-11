/*
 * Copyright 2018 Rohit Awate.
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

package com.rohitawate.everest.requestmanager;

import com.rohitawate.everest.models.responses.EverestResponse;
import javafx.concurrent.Task;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.core.Response;

public class GETRequestManager extends RequestManager {

    @Override
    protected Task<EverestResponse> createTask() throws ProcessingException {
        return new Task<EverestResponse>() {
            @Override
            protected EverestResponse call() throws Exception {
                initialTime = System.currentTimeMillis();
                Response serverResponse = requestBuilder.get();
                finalTime = System.currentTimeMillis();

                processServerResponse(serverResponse);

                return response;
            }
        };
    }
}
