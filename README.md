# Sprint_4
AbstractPage и AbstractTest - абстрактные классы для страниц и тестов соотвественно.

Менять WebDriver нужно в AbstractTest.

[Основное задание] {ImportantQuestionsTest.checkIsDisplayAnswerAfterClickQuestionButton} Выпадающий список в разделе «Вопросы о важном»:
Проврил только на видимость ответа, возможно не допонял задание.

[Основное задание] {PositiveOrderTest.positiveCreateOrderTest} Заказ самоката

[Дополнительное задание] {LogoTest.checkLogoScooterSendsToMainPage} Проверка нажатия на логтип Самоката.

[Дополнительное задание] {LogoTest.checkLogoYandexOpenYandexMainPageInNewTab} Проверка нажатия на логотип Яндекса:
Не уверен является ли Дзен - главной страницей Яндекса, но в рамках задания предположил, что да.
Тест работает с ChromeDriver.
FirefoxDriver после переключения вкладок некоректо возвращает текущий URL.

[Дополнительное задание] {NegativeOrderWithNonValidUserDataTest.createOrderWithNonValidParam} Проверка ошибок для всех полей формы заказа:
Проверка на невалидные данные пользователя.

[Дополнительное задание] {NegativeOrderWithEmptyFieldTest.createOrderWithEmptyField} Проверка ошибок для всех полей формы заказа:
Проверка на пустые поля.
Фактически работает только при оставлении пустым поля с данными клиента.
При оставлении пустых полей с датой заказа и сроком аренды ошибок нет, соответсвенно и искать нечего. Проверять, что при нажатии на кнопку подтверждения заказа ничего не происходт, на мой взгляд бессмысленно.

[Дополнительное задание] {WrongOrderNumberTest.checkNoOrderMessageAfterSearchWrongNumber} Проверка поиска неверного номера заказа.