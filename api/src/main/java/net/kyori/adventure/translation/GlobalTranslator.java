/*
 * This file is part of adventure, licensed under the MIT License.
 *
 * Copyright (c) 2017-2020 KyoriPowered
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package net.kyori.adventure.translation;

import java.util.Locale;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.renderer.TranslatableComponentRenderer;
import net.kyori.examination.Examinable;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * A global source of translations.
 *
 * @since 4.0.0
 */
public interface GlobalTranslator extends Translator, Examinable {
  /**
   * Gets the global translation source.
   *
   * @return the source
   * @since 4.0.0
   */
  static @NonNull GlobalTranslator get() {
    return GlobalTranslatorImpl.INSTANCE;
  }

  /**
   * Gets a renderer which uses the global source for translating.
   *
   * @return a renderer
   * @since 4.0.0
   */
  static @NonNull TranslatableComponentRenderer<Locale> renderer() {
    return GlobalTranslatorImpl.INSTANCE.renderer;
  }

  /**
   * Renders a component using the {@link #renderer() global renderer}.
   *
   * @param component the component to render
   * @param locale the locale to use when rendering
   * @return the rendered component
   * @since 4.0.0
   */
  static @NonNull Component render(final @NonNull Component component, final @NonNull Locale locale) {
    return renderer().render(component, locale);
  }

  /**
   * Gets the sources.
   *
   * @return the sources
   * @since 4.0.0
   */
  @NonNull Iterable<? extends Translator> sources();

  /**
   * Adds a translation source.
   *
   * <p>Duplicate sources will be ignored.</p>
   *
   * @param source the source
   * @return {@code true} if registered, {@code false} otherwise
   * @throws IllegalArgumentException if source is {@link GlobalTranslator}
   * @since 4.0.0
   */
  boolean addSource(final @NonNull Translator source);

  /**
   * Removes a translation source.
   *
   * @param source the source to unregister
   * @return {@code true} if unregistered, {@code false} otherwise
   * @since 4.0.0
   */
  boolean removeSource(final @NonNull Translator source);
}
