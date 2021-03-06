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
package ar.com.quark.system.utility.array;

import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * <code>Array</code> encapsulate a cross-platform efficient container for holding any type of data.
 */
public interface Array<A extends Array> {
    /**
     * @see Buffer#capacity()
     */
    int capacity();

    /**
     * @see Buffer#limit()
     */
    int limit();

    /**
     * @see Buffer#limit(int)
     */
    A limit(int limit);

    /**
     * @see Buffer#position()
     */
    int position();

    /**
     * @see Buffer#position(int)
     */
    A position(int position);

    /**
     * @see Buffer#remaining()
     */
    int remaining();

    /**
     * @see Buffer#hasRemaining()
     */
    boolean hasRemaining();

    /**
     * @see Buffer#clear()
     */
    A clear();

    /**
     * @see Buffer#flip()
     */
    A flip();

    /**
     * @see Buffer#rewind()
     */
    A rewind();

    /**
     * @see ByteBuffer#array()
     */
    <B> B data();

    /**
     * @see ByteBuffer#put(byte)
     */
    A writeInt8(int value);

    /**
     * @see ByteBuffer#put(byte[])
     */
    default A writeInt8(byte[] value) {
        return writeInt8(value, 0, value.length);
    }

    /**
     * @see ByteBuffer#put(byte[], int, int)
     */
    A writeInt8(byte[] value, int offset, int count);

    /**
     * @see ByteBuffer#put(int, byte)
     */
    A writeInt8(int index, int value);

    /**
     * @see ByteBuffer#putShort(short)
     */
    A writeInt16(int value);

    /**
     * @see java.nio.ShortBuffer#put(short[])
     *
     */
    default A writeInt16(short[] value) {
        return writeInt16(value, 0, value.length);
    }

    /**
     * @see java.nio.ShortBuffer#put(short[], int, int)
     */
    A writeInt16(short[] value, int offset, int count);

    /**
     * @see ByteBuffer#putShort(int, short)
     */
    A writeInt16(int index, int value);

    /**
     * @see ByteBuffer#putInt(int)
     */
    A writeInt32(int value);

    /**
     * @see java.nio.IntBuffer#put(int[])
     */
    default A writeInt32(int[] value) {
        return writeInt32(value, 0, value.length);
    }

    /**
     * @see java.nio.IntBuffer#put(int[], int, int)
     */
    A writeInt32(int[] value, int offset, int count);

    /**
     * @see ByteBuffer#putInt(int, int)
     */
    A writeInt32(int index, int value);

    /**
     * @see ByteBuffer#putFloat(float)
     */
    A writeFloat32(float value);

    /**
     * @see java.nio.FloatBuffer#put(float[])
     */
    default A writeFloat32(float[] value) {
        return writeFloat32(value, 0, value.length);
    }

    /**
     * @see java.nio.FloatBuffer#put(float[], int, int)
     */
    A writeFloat32(float[] value, int offset, int count);

    /**
     * @see ByteBuffer#putFloat(int, float)
     */
    A writeFloat32(int index, float value);

    /**
     * @see ByteBuffer#put(byte[])
     */
    default A writeString(String value) {
        final byte[] bytes = value.getBytes();
        return (A) writeInt16(bytes.length).writeInt8(bytes);
    }

    /**
     * @see ByteBuffer#get()
     */
    byte readInt8();

    /**
     * @see ByteBuffer#get(int)
     */
    byte readInt8(int index);

    /**
     * @see ByteBuffer#getShort()
     */
    short readInt16();

    /**
     * @see ByteBuffer#getShort(int)
     */
    short readInt16(int index);

    /**
     * @see ByteBuffer#getInt()
     */
    int readInt32();

    /**
     * @see ByteBuffer#getInt(int)
     */
    int readInt32(int index);

    /**
     * @see ByteBuffer#getFloat()
     */
    float readFloat32();

    /**
     * @see ByteBuffer#getFloat(int)
     */
    float readFloat32(int index);

    /**
     * @see ByteBuffer#get(byte[])
     */
    default String readString() {
        final byte[] bytes = new byte[readInt16()];
        read(bytes);

        return new String(bytes);
    }

    /**
     * @see ByteBuffer#get(byte[])
     */
    default int read(byte[] value) {
        return read(value, 0, value.length);
    }

    /**
     * @see ByteBuffer#get(byte[], int, int)
     */
    int read(byte[] value, int offset, int count);
}
