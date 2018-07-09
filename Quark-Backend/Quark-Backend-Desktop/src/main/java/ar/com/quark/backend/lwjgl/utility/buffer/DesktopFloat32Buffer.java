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
package ar.com.quark.backend.lwjgl.utility.buffer;

import ar.com.quark.utility.buffer.Float32Buffer;

import java.nio.FloatBuffer;

/**
 * Implementation for {@link Float32Buffer}.
 */
public final class DesktopFloat32Buffer extends DesktopBuffer<Float32Buffer, FloatBuffer> implements Float32Buffer {
    /**
     * <p>Constructor</p>
     */
    public DesktopFloat32Buffer(FloatBuffer underlying) {
        super(underlying);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Float32Buffer write(float value) {
        mUnderlying.put(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Float32Buffer write(float[] values) {
        mUnderlying.put(values);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Float32Buffer write(float[] values, int offset, int count) {
        mUnderlying.put(values, offset, count);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public float read() {
        return mUnderlying.get();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Float32Buffer copy(Float32Buffer other) {
        mUnderlying.put(other.<FloatBuffer>underlying());
        return this;
    }
}