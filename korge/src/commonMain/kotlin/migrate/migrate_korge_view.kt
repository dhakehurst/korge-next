@file:Suppress("RedundantVisibilityModifier", "unused", "PackageDirectoryMismatch", "UNUSED_PARAMETER")

package com.soywiz.korge.view

import com.soywiz.klock.TimeSpan
import com.soywiz.korim.bitmap.BmpSlice
import com.soywiz.korio.lang.Cancellable
import com.soywiz.korma.geom.Angle

/**
 * Migrate from version 1.15.1 to 2.0.0
 */
@Deprecated(
    message = "Need to migrate to addUpdater()",
    replaceWith = ReplaceWith("addUpdater(updatable)"),
    level = DeprecationLevel.ERROR
)
public inline fun <T : View> T.addHrUpdater(updatable: T.(dt: TimeSpan) -> Unit): Cancellable {
    throw Error("migrate to addHrUpdater")
}

/**
 * Migrate from version 1.15.1 to 2.0.0
 */
@Deprecated(
    message = "Need to migrate to rotation",
    replaceWith = ReplaceWith("rotation"),
    level = DeprecationLevel.ERROR
)
public inline var View.rotationDegrees: Angle
    get() {
        throw Error("migrate to rotationDegrees")
    }
    set(v) {
        throw Error("migrate to rotationDegrees")
    }

/**
 * Migrate from version 1.15.1 to 2.0.0
 */
@property:Deprecated(
    message = "Need to migrate to smoothing",
    replaceWith = ReplaceWith("smoothing"),
    level = DeprecationLevel.ERROR
)
public inline var Text.filtering: Boolean
    get() = throw Error("migrate to filtering")
    set(value) = throw Error("migrate to filtering")

/**
 * Migrate from version 1.15.1 to 2.0.0
 */
@property:Deprecated(
    message = "Need to migrate to bitmap",
    replaceWith = ReplaceWith("bitmap"),
    level = DeprecationLevel.ERROR
)
public inline var BaseImage.texture: BmpSlice
    get() = throw Error("migrate to texture")
    set(value) = throw Error("migrate to texture")

