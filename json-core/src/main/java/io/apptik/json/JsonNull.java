/*
 * Copyright (C) 2014 Kalin Maldzhanski
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

package io.apptik.json;

import java.io.IOException;

public final class JsonNull extends JsonElement {
    
    @Override
    public boolean isNull() {
        return true;
    }

   @Override
    public int hashCode() {
        return JsonNull.class.hashCode();
    }

    @Override
    public boolean equals( Object o ) {
        return o==null || o instanceof JsonNull;
    }

    @Override
    public void write( JsonWriter writer ) throws IOException {
        writer.nullValue();
    }

    @Override
    public String toString() {
        return "null";
    }

    @Override
    public String getJsonType() {
        return "null";
    }


}
