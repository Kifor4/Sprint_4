# Sprint_4
AbstractPage и AbstractTest - абстрактные классы для страниц и тестов соотвественно.

Менять WebDriver нужно в AbstractTest.

[Основное задание] {ImportantQuestionsTest.checkIsDisplayAnswerAfterClickQuestionButton} Выпадающий список в разделе «Вопросы о важном».

[Основное задание] {PositiveOrderTest.positiveCreateOrderTest} Заказ самоката.

[Дополнительное задание] {LogoTest.checkLogoScooterSendsToMainPage} Проверка нажатия на логотип Самоката.

[Дополнительное задание] {LogoTest.checkLogoYandexOpenYandexMainPageInNewTab} Проверка нажатия на логотип Яндекса:
Не уверен является ли Дзен - главной страницей Яндекса, но в рамках задания предположил, что да.
Тест работает с ChromeDriver.
FirefoxDriver после переключения вкладок некоректо возвращает текущий URL.

[Дополнительное задание] {NegativeOrderWithNonValidUserDataTest.createOrderWithNonValidParam} Проверка ошибок для всех полей формы заказа:
Проверка на невалидные данные пользователя.

[Дополнительное задание] {NegativeOrderWithEmptyFieldTest} Проверка ошибок для всех полей формы заказа:
Проверки на пустые поля.
При проверке пустых полей с данными клиента проверяется наличие видимого сообщения об ошибке.
При проверке пустых полей с информацией о заказе ошибки отсутствуют, поэтому проверяется, что процесс оформления не пошел дальше.

[Дополнительное задание] {WrongOrderNumberTest.checkNoOrderMessageAfterSearchWrongNumber} Проверка поиска неверного номера заказа.