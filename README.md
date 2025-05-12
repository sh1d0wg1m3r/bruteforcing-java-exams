# Bruteforcing Java Exams

<div align="center">

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Python 3.8+](https://img.shields.io/badge/python-3.8+-blue.svg)](https://www.python.org/downloads/)
[![Gemini API](https://img.shields.io/badge/API-Gemini%202.5-brightgreen.svg)](https://ai.google.dev/gemini-api)
[![Status: Experimental](https://img.shields.io/badge/Status-Experimental-purple.svg)]()

> "If you are worried about an upcoming Java exam, just generate 1000 variations instead of studying" - A Bulgarian student

</div>

## What This Actually Does

This tool generates tons of Java exam questions using Google's Gemini API. Is it better than actually studying Java properly? Definitely not. But it might help you spot patterns in how exam questions are structured if you've got a test coming up and need focused practice.

The core idea is simple: Java exams, despite seeming endless in variety, actually follow predictable patterns. By generating hundreds of questions, you start to see these patterns more clearly than you might from a textbook.

## When This Might Help

- You've already studied the core concepts but want to see them in different contexts
- You need to practice recognizing exam patterns quickly
- You learn better from examples than abstract explanations
- You're worried about seeing unexpected question formats on your exam

## When This Won't Help

- You haven't learned basic Java concepts yet
- You need to understand *why* certain approaches work
- You're looking for personalized feedback on your code
- You want to truly master Java (there are no shortcuts for that)

## How It Works

The generator creates Java exam questions with solutions by:

1. Feeding detailed prompts to Google's Gemini 2.5 API
2. Running multiple accounts in parallel to get around rate limits
3. Tracking performance stats and showing them in a nice terminal UI
4. Saving everything as properly formatted Java files

## What You'll Get

Each generated question includes:

- A detailed problem statement (like you'd see on an exam)
- A complete Java solution that works
- An explanation of the approach used

All questions incorporate key Java concepts like collections, exception handling, user input, and control flow - the stuff that shows up on exams.
And 1000 iterations of that ( will add more as I plan to hit 10k ) 

## Setting It Up

```bash
# Clone the repository
git clone https://github.com/sh1d0wg1m3r/bruteforcing-java-exams.git
cd bruteforcing-java-exams

# Install required packages
pip install -r requirements.txt
```

Before running anything, add your own Gemini API keys to the script. The public repository has fake placeholder keys.

## Running It ( will upload in a day or 2 needs cleanup ) 

```bash
python java-exam-generator.py
```

You'll get a menu with options to:

1. Generate a single question (if you want to examine one in detail)
2. Start auto-generating a bunch at once
3. View stats on your API usage and generation speed

## Important Notes

- **This is a practice tool, not a learning tool**: It helps reinforce what you already know, not teach you new concepts
- **API Keys**: Don't forget to remove any real API keys before sharing your code
- **Best used alongside actual study**: This works best when combined with proper learning resources

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Idea sparked by a conversation with a Bulgarian CS student prepping for exams
- Powered by Google's Gemini 2.5 Flash Preview API
- Terminal UI built with [Rich](https://github.com/Textualize/rich)

---

<div align="center">
<p><i>This won't make you a Java expert, but it might help you pass that exam.</i></p>
</div>
