require: slotfilling/slotFilling.sc
  module = sys.zb-common
require: scripts/functions.js
theme: /

    state: Start
        q!: $regex</start>
        a: Привет! Я тестовый чат бот и пока я умею только здороваться и прощаться

    state: Hello
        intent!: /привет
        a: Привет привет

    state: Bye
        intent!: /пока
        a: Пока пока
    
    state: тест
        intent!: /тест
        a: тест успеше

    state: NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}

    state: Match
        event!: match
        a: {{$context.intent.answer}}