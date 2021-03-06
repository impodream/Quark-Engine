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

import ar.com.quark.render.shader.UniformType;
import ar.com.quark.mathematic.MutableVector3i;
import ar.com.quark.mathematic.Vector3i;
import ar.com.quark.render.shader.Uniform;

/**
 * <code>UniformUnsignedInt3</code> encapsulate an {@link Uniform} for {@link UniformType#UInt3}.
 */
public final class UniformUnsignedInt3 extends Uniform {
    private final MutableVector3i mValue = MutableVector3i.zero();

    /**
     * <p>Constructor</p>
     */
    public UniformUnsignedInt3(Vector3i value) {
        super(UniformType.UInt3);
        setValue(value);
    }

    /**
     * <p>Get the value of the data</p>
     *
     * @return the value of the data
     */
    public Vector3i getValue() {
        return mValue;
    }

    /**
     * <p>Change the value of the data</p>
     *
     * @param newValue the new value of the data
     */
    public void setValue(Vector3i newValue) {
        setValue(newValue.getX(), newValue.getY(), newValue.getZ());
    }

    /**
     * <p>Change the value of the data</p>
     *
     * @param newX the new x value of the data
     * @param newY the new y value of the data
     * @param newZ the new z value of the data
     */
    public void setValue(int newX, int newY, int newZ) {
        if (mValue.getX() != newX || mValue.getY() != newY|| mValue.getZ() != newZ  ) {
            mValue.setXYZ(newX, newY, newZ);
            setUpdate(CONCEPT_VALUE);
        }
    }
}
