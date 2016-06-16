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
package org.quark.render.texture;

/**
 * <code>Texture2D</code> encapsulate a {@link Texture} of 2 dimension.
 */
public final class Texture2D extends Texture {
    protected TextureBorder mBorderX = TextureBorder.REPEAT;
    protected TextureBorder mBorderY = TextureBorder.REPEAT;

    /**
     * <p>Constructor</p>
     */
    public Texture2D(TextureFormat format, Image image) {
        super(TextureType.TEXTURE_2D, format, image);
    }

    /**
     * <p>Constructor</p>
     */
    public Texture2D(TextureFormat format, TextureFilter filter,
            TextureBorder borderX,
            TextureBorder borderY, Image image) {
        this(format, image);
        setFilter(filter);
        setClamp(borderX, borderY);
    }

    /**
     * <p>Change the border mode for the x and y coordinate</p>
     *
     * @param xBorder the new border mode for the x coordinate
     * @param yBorder the new border mode for the y coordinate
     */
    public void setClamp(TextureBorder xBorder, TextureBorder yBorder) {
        if (mBorderX != xBorder) {
            mBorderX = xBorder;
            setUpdate(CONCEPT_CLAMP_X);
        }
        if (mBorderY != yBorder) {
            mBorderY = yBorder;
            setUpdate(CONCEPT_CLAMP_Y);
        }
    }

    /**
     * <p>Get the border mode for the x coordinate</p>
     *
     * @return the border mode for the x coordinate
     */
    public TextureBorder getBorderX() {
        return mBorderX;
    }

    /**
     * <p>Get the border mode for the y coordinate</p>
     *
     * @return the border mode for the y coordinate
     */
    public TextureBorder getBorderY() {
        return mBorderY;
    }
}
