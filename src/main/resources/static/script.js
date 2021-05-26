const startButton = document.getElementById('start-btn')
const nextButton = document.getElementById('next-btn')
const questionContainerElement = document.getElementById('question-container')
const questionElement = document.getElementById('question')
const answerButtonsElement = document.getElementById('answer-buttons')

let shuffledQuestions, currentQuestionIndex

startButton.addEventListener('click', startGame)
nextButton.addEventListener('click', () => {
    currentQuestionIndex++
    setNextQuestion()
})

function startGame() {
    startButton.classList.add('hide')
    shuffledQuestions = questions.sort(() => Math.random() - .5)
    currentQuestionIndex = 0
    questionContainerElement.classList.remove('hide')
    setNextQuestion()
}

function setNextQuestion() {
    resetState()
    showQuestion(shuffledQuestions[currentQuestionIndex])
}

function showQuestion(question) {
    questionElement.innerText = question.question
    question.answers.forEach(answer => {
        const button = document.createElement('button')
        button.innerText = answer.text
        button.classList.add('btn')
        if (answer.correct) {
            button.dataset.correct = answer.correct
        }
        button.addEventListener('click', selectAnswer)
        answerButtonsElement.appendChild(button)
    })
}

function resetState() {
    clearStatusClass(document.body)
    nextButton.classList.add('hide')
    while (answerButtonsElement.firstChild) {
        answerButtonsElement.removeChild(answerButtonsElement.firstChild)
    }
}

function selectAnswer(e) {
    const selectedButton = e.target
    const correct = selectedButton.dataset.correct
    setStatusClass(document.body, correct)
    Array.from(answerButtonsElement.children).forEach(button => {
        setStatusClass(button, button.dataset.correct)
    })
    if (shuffledQuestions.length > currentQuestionIndex + 1) {
        nextButton.classList.remove('hide')
    } else {
        startButton.innerText = 'Restart'
        startButton.classList.remove('hide')
    }
}

function setStatusClass(element, correct) {
    clearStatusClass(element)
    if (correct) {
        element.classList.add('correct')
    } else {
        element.classList.add('wrong')
    }
}

function clearStatusClass(element) {
    element.classList.remove('correct')
    element.classList.remove('wrong')
}

const questions = [
    {
        question: 'What is 2 + 2?',
        answers: [
            { text: '4', correct: true },
            { text: '22', correct: false },
            { text: '10', correct: false },
            { text: '6', correct: false }
        ]
    },
    {
        question: 'What is the largest planet in our solar system?',
        answers: [
            { text: 'Saturn', correct: false },
            { text: 'Jupiter', correct: true },
            { text: 'The Sun', correct: false },
            { text: 'Earth', correct: false }
        ]
    },
    {
        question: 'What is more important?',
        answers: [
            { text: 'HTML', correct: false },
            { text: 'JS', correct: false },
            { text: 'CSS', correct: false },
            { text: 'ALL', correct: true }
        ]
    },
    {
        question: 'What is 4 * 2?',
        answers: [
            { text: '6', correct: false },
            { text: '8', correct: true },
            { text: '9', correct: false },
            { text: '15', correct: false }
        ]
    },
    {
        question: 'What country is London located in?',
        answers: [
            { text: 'US', correct: false },
            { text: 'UK', correct: true },
            { text: 'UAE', correct: false },
            { text: 'Zimbabwe', correct: false }
        ]
    },
    {
        question: 'Which of these people is NOT a CEO?',
        answers: [
            { text: 'Tim Cook', correct: false },
            { text: 'Bill Gates', correct: true },
            { text: 'Mark Zuckerberg', correct: false },
            { text: 'Jeff Bezos', correct: false }
        ]
    },
    {
        question: 'Which of these is not a programming language?',
        answers: [
            { text: 'Java', correct: false },
            { text: 'Pudding', correct: true },
            { text: 'Python', correct: false },
            { text: 'C++', correct: false }
        ]
    },
    {
        question: 'What is the longest river in the world?',
        answers: [
            { text: 'Amazon', correct: false },
            { text: 'Nile', correct: true },
            { text: 'Euphrates', correct: false },
            { text: 'Hudson', correct: false }
        ]
    }
]