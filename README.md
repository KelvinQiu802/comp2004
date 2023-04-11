# Monopoly Deal

## Configure Commit Lint Hook

```shell
$ chmod ug+x .githooks/*
$ git config core.hooksPath .githooks
```

[🌈Conventional Commits😋](https://www.conventionalcommits.org/en/v1.0.0/)

## Class Diagram

```mermaid
classDiagram
	AbstractCard <|-- MoneyCard
	AbstractCard <|-- ActionCard
	AbstractCard <|-- PropertyCard
	AbstractCard <.. CardTypes
	MoneyCard <|-- IBankCard
	ActionCard <|-- IBankCard
	Player "1" *-- "1" Bank
	
	class AbstractCard{
		<<Abstract>>
		-String name
		-CardTypes type
		-int value
		-String description
		+play()*
	}
		
	class MoneyCard
	
	class ActionCard
	
	class PropertyCard
	
	class IBankCard{
			<<Interface>>
	}
		
	class Player{
		-String name
		-List~AbstractCard~ handCards
		-Bank bank
		+draw()
		+play()
		-dropToCenter()
		+isWin()
	}

	class Bank{
		-List~IBankCard~ bankCards
		+add()
		+remove()
	}
	
	class CardTypes{
		<<Enumeration>>
		MONEY
		ACTION
		PROPERTY
	}
```
