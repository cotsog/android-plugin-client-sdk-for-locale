/*
 * android-plugin-client-sdk-for-locale https://github.com/twofortyfouram/android-plugin-client-sdk-for-locale
 * Copyright 2014 two forty four a.m. LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.twofortyfouram.locale.sdk.client.internal;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.twofortyfouram.locale.sdk.client.R;

import net.jcip.annotations.ThreadSafe;

import static com.twofortyfouram.assertion.Assertions.assertNotNull;

/**
 * Utility class to generate a breadcrumb title string for {@code Activity}
 * instances in Locale.
 */
@ThreadSafe
public final class BreadCrumber {

    /**
     * Generates bread crumb titles for Locale plug-in Activities. Bread crumb
     * strings will be properly formatted for the current language, including
     * right-to-left languages, as long as the proper string resources have been
     * created.
     *
     * @param context      Application context.
     * @param intent       {@code Intent} to extract the bread crumb from.
     * @param currentCrumb The last element of the bread crumb path.
     * @return {@code String} presentation of the bread crumb. If the intent
     * parameter is null, then this method returns currentCrumb.
     */
    @NonNull
    public static CharSequence generateBreadcrumb(@NonNull final Context context,
                                                  @Nullable final Intent intent, @NonNull final String currentCrumb) {
        assertNotNull(context, "context"); //$NON-NLS-1$
        assertNotNull(currentCrumb, "currentCrumb"); //$NON-NLS-1$

        String result = currentCrumb;
        if (null != intent) {
            final String breadcrumbString = intent
                    .getStringExtra(com.twofortyfouram.locale.api.Intent.EXTRA_STRING_BREADCRUMB);
            if (null != breadcrumbString) {
                result = context.getString(R.string.com_twofortyfouram_locale_sdk_client_breadcrumb_format, breadcrumbString, context.getString(R.string.com_twofortyfouram_locale_sdk_client_breadcrumb_separator), currentCrumb);
            }
        }
        return result;
    }

    /**
     * Private constructor prevents instantiation.
     *
     * @throws UnsupportedOperationException because this class cannot be
     *                                       instantiated.
     */
    private BreadCrumber() {
        throw new UnsupportedOperationException("This class is non-instantiable"); //$NON-NLS-1$
    }
}
