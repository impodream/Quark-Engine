/*
 * This file is part of Quark Framework, licensed under the APACHE License.
 *
 * Copyright (c) 2014-2016 Agustin L. Alvarez <wolftein1@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ar.com.quark.render.shader.data;

import ar.com.quark.render.shader.Uniform;
import ar.com.quark.render.shader.UniformType;

/**
 * <code>UniformInt</code> encapsulate an {@link Uniform} for {@link UniformType#Int}.
 */
public final class UniformInt extends Uniform {
    private int mValue;

    /**
     * <p>Default constructor</p>
     */
    public UniformInt(int value) {
        super(UniformType.Int);
        setValue(value);
    }

    /**
     * <p>Get the value of the data</p>
     *
     * @return the value of the data
     */
    public int getValue() {
        return mValue;
    }

    /**
     * <p>Change the value of the data</p>
     *
     * @param newValue the new value of the data
     */
    public void setValue(int newValue) {
        if (mValue != newValue) {
            mValue = newValue;
            setUpdate(CONCEPT_VALUE);
        }
    }
}