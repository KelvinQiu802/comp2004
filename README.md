# Monopoly Deal

<p align="center">
  <img src="https://imgbed.codingkelvin.fun/uPic/favpng_monopoly-rich-uncle-pennybags-logo-board-game.png" alt="Monopoly Icon" style="height:150px;" />
</p>

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
	DrawPile o-- AbstractCard
	PropertyCard <|-- SingleColorProperty
	PropertyCard <|-- DoubleColorProperty
	PropertyCard <|-- WildCard
	PropertyCard <.. Colors
	
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
	
	class PropertyCard{
		-Colors currentColor
	}
	
	class SingleColorProperty
	
	class DoubleColorProperty
	
	class WildCard
	
	class Colors{
		<<Enumeration>>
		GREEN
		DARK_BLUE
		LIGHT_BLUE
		RED
		UTILITY
		YELLOW
		ORANGE
		BROWN
		PURPLE
		RAILROAD
	}
	
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
	
	class DrawPile{
		-List~AbstractCard~usingCards
		-List~AbstractCard~usedCards
		+swap()
		+drop()
		+take()
		+shuffle()
	}
```
