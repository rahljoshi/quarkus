package io.quarkus.qute;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SetSectionTest {

    @Test
    public void testSet() {
        Engine engine = Engine.builder().addDefaults().build();
        assertEquals("NOT_FOUND - true:mix",
                engine.parse("{foo} - {#set foo=true bar='mix'}{foo}:{bar}{/}").render());
    }

    @Test
    public void testLet() {
        Engine engine = Engine.builder().addDefaults().build();
        assertEquals("NOT_FOUND:what?! - true:mix:what?!",
                engine.parse("{foo}:{baz} - {#let foo=true bar='mix'}{foo}:{bar}:{baz}{/}").data("baz", "what?!").render());
    }

}
