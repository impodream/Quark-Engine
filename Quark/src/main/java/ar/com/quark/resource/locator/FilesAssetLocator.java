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
package ar.com.quark.resource.locator;

import ar.com.quark.resource.AssetCallback;
import ar.com.quark.resource.AssetLocator;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;

/**
 * Encapsulate an {@link AssetLocator} that search asset(s) using {@link FileSystem}.
 */
public final class FilesAssetLocator implements AssetLocator {
    private final FileSystem mFilesystem;

    /**
     * <p>Constructor</p>
     */
    public FilesAssetLocator() {
        mFilesystem = FileSystems.getDefault();
    }

    /**
     * <p>Constructor</p>
     */
    public FilesAssetLocator(Path location) {
        try {
            mFilesystem = FileSystems.newFileSystem(location, null);
        } catch (IOException exception) {
            throw new IllegalStateException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isSynchronousSupported() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAsynchronousSupported() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InputStream locate(String filename) {
        final Path child = mFilesystem.getPath(filename);

        if (Files.exists(child) && Files.isReadable(child)) {
            try {
                return Files.newInputStream(child, StandardOpenOption.READ);
            } catch (IOException ignored) {
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InputStream locate(String filename, AssetCallback<InputStream> callback) {
        final InputStream input = locate(filename);

        if (input != null) {
            callback.onSuccess(input);
        } else {
            callback.onFail();
        }
        return input;
    }
}
