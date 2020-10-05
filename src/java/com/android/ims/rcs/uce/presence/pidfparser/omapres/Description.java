/*
 * Copyright (C) 2020 The Android Open Source Project
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

package com.android.ims.rcs.uce.presence.pidfparser.omapres;

import com.android.ims.rcs.uce.presence.pidfparser.ElementBase;

import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;

/**
 * The "description" element of the pidf
 */
public class Description extends ElementBase {
    private final String mDescription;

    public Description(String description) {
        mDescription = description;
    }

    @Override
    protected String initNamespace() {
        return OmaPresConstant.NAMESPACE;
    }

    @Override
    protected String initElementName() {
        return "description";
    }

    @Override
    public void serialize(XmlSerializer serializer) throws IOException {
        if (mDescription == null) {
            return;
        }
        String namespace = getNamespace();
        String elementName = getElementName();
        serializer.startTag(namespace, elementName);
        serializer.text(mDescription);
        serializer.endTag(namespace, elementName);
    }
}
