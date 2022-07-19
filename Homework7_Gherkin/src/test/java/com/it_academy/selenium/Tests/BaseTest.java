package com.it_academy.selenium.Tests;

import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    @BeforeEach
    public void navigateToOnliner() {
        open("https:www.onliner.by");
    }
}
