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
package org.quark.backend.teavm.opengl;

import org.quark.render.Render;
import org.teavm.jso.dom.html.HTMLCanvasElement;

/**
 * <a href="http://teavm.org/">TeaVM</a> implementation for {@link Render.GLES31}.
 */
public class TeaVMOpenGLES31 extends TeaVMOpenGLES30 implements Render.GLES31 {
    /**
     * <p>Constructor</p>
     */
    public TeaVMOpenGLES31(HTMLCanvasElement canvas) {
        super(canvas);
    }
}
