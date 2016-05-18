/*
 * This file is part of Quark Engine, licensed under the APACHE License.
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
package org.quark.engine.core;

/**
 * <code>EngineLifecycle</code> represent the lifecycle of {@link Engine}.
 *
 * @author Agustin L. Alvarez (wolftein1@gmail.com)
 */
public interface EngineLifecycle {
    /**
     * <p>Called when the engine is created</p>
     *
     * @param engine the instance of the <code>Engine</code>
     */
    void onCreate(Engine engine);

    /**
     * <p>Called when the engine has resize</p>
     *
     * @param width  the new width (in pixel) of the display
     * @param height the new height (in pixel) of the display
     */
    void onResize(int width, int height);

    /**
     * <p>Called when the engine require to render</p>
     *
     * @param time the time (in millisecond) since the last render
     */
    void onRender(float time);

    /**
     * <p>Called when the engine has been pause from a running state</p>
     *
     * @see #onResume()
     */
    void onPause();

    /**
     * <p>Called when the engine has been resume from a pause state</p>
     *
     * @see #onPause()
     */
    void onResume();

    /**
     * <p>Called when the engine is disposed</p>
     *
     * @param engine the instance of the <code>Engine</code>
     */
    void onDispose(Engine engine);
}
