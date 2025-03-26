# Python Basics

These are some old notes as a starting point.

My Python learning is pretty basic.

I started with [MicroPython](https://micropython.org/) as used for the [ Raspberry Pi Pico](https://www.raspberrypi.com/products/raspberry-pi-pico/) micro controller.

Then used the [Django](https://www.djangoproject.com/) REST framework for API development.

I have also used Python to use TensorFlow and PyTorch for machine learning a bit.

## Links

[Things I wish I knew way earlier](https://levelup.gitconnected.com/20-python-concepts-i-wish-i-knew-way-earlier-573cd189c183).

## Tuple unpacking

Add `*` in front of variables to unpack everything else into that variable.

[Functional programming in Python](https://realpython.com/python-functional-programming/).

## Dunder methods

Magic methods

```__str__```.

```py
class Vector2D:
    def __init__(self, x, y):
        self.x = x
        self.y = y
def __repr__(self):
        return f"Vector2D(x={self.x}, y={self.y})"
v = Vector2D(3, 5)
print(v)

How does __repr__ get called in print?
That's magic

__str__ seems the same
```

https://www.kdnuggets.com/11-python-magic-methods-every-programmer-should-know

default the comparison checks for equality of the object IDs in memory.

## Linting

I usually use the [Code Institute](https://codeinstitute.net/global/) [Pep8 linter](https://pep8ci.herokuapp.com/) as part of my full stack web development student project assessment work.

There are other options however.

[Ruff](https://docs.astral.sh/ruff/), is another Python linter.

Or there are "ruff format” linters like [Flake8](https://pypi.org/project/flake8/), [Pylint](https://pypi.org/project/pylint/) or [Black](https://pypi.org/project/black/).

Ruff is and *extremely fast and accurate and is quickly adopted by the community*.

## Metaflow

https://pypi.org/project/metaflow/

Metaflow is available as a Python package for macOS and Linux. You can visit our GitHub repository or get the latest version from PyPI:

pip install metaflow

We highly recommend using Python 3 for new projects. Metaflow supports Python 2.7 for legacy applications, but Python 3 has fewer bugs and is better supported than the deprecated Python 2.7.

from metaflow import step, FlowSpec, conda_base
https://vs-pw-1797420730.outerbounds.dev/?workspace=/home/workspace/workspaces/tutorials/workspace.code-workspace

```py
class HelloFlow(FlowSpec):
    @step
    def start(self):
        print("Starting 👋")
        self.next(self.eat)

    @step
    def eat(self):
        print("Eating 🍜")
        self.next(self.end)

    @step
    def end(self):
        print("Done! 🏁")

if __name__ == "__main__":
    HelloFlow()

# The if __name__ == "__main__": block ensures that the flow is executed only when the script is run directly (not when imported as a module).
```

## venv

virtual environments for Python
While learning how to Securely Deploy a Django App With Gunicorn, Nginx, & HTTPS (https://realpython.com/django-nginx-gunicorn/) I went down the rabbit hole of virtual envs.

https://realpython.com/python-virtual-environments-a-primer/

> python --version
Python 3.10.11

Drf-two/pytorch
python3-openid==3.2.0

Django blog
Django==3.2

python3-openid==3.2.0

Primer version
PS> python -m venv venv
PS> venv\Scripts\activate
… install with pip
(venv) PS> deactivate
PS>


DNG version (for Python 3.8.10 Ubuntu)
$ cd  # Change directory to home directory
$ python3 -m venv env
$ source env/bin/activate

On Windows, virtualenv creates a .bat/.ps1 file, so you should run venv\Scripts\activate instead (per the virtualenv documentation on the activate script).

Just run activate, without an extension, so the right file will get used regardless of whether you're using cmd.exe or PowerShell.

## Genetic Algorithm

How to Build a Genetic Algorithm from Scratch in Python
A complete walkthrough on how one can build a Genetic Algorithm from scratch in Python, along with a real-world use case
Jacob Ingle
