require: slotfilling/slotFilling.sc
  module = sys.zb-common
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
    
    state:
    intent!: /Погода
    script:
        if ($parseTree._Date) {
            $temp.date = $parseTree._Date.value;
        } else {
            $temp.date = "сегодня";
        }
        a: Погода в {{$parseTree._City}} на {{$temp.date}}

    state: NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}

    state: Match
        event!: match
        a: {{$context.intent.answer}}