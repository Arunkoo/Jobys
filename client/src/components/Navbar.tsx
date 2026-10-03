import { BriefcaseBusiness, Moon, Sun } from "lucide-react";
import { useAppContext } from "@/context/useAppContext";

export function Navbar() {
  const { isDarkMode, toggleDarkMode } = useAppContext();

  return (
    <header className="relative z-10 border-b border-border bg-background">
      <div className="mx-auto flex max-w-7xl flex-wrap items-center justify-between gap-x-6 gap-y-4 px-5 py-3.5 lg:px-8">
        <a
          href="#top"
          className="flex items-center gap-2.5 font-bold tracking-tight"
        >
          <span className="grid size-7 place-items-center bg-accent text-accent-foreground">
            <BriefcaseBusiness size={16} strokeWidth={2.5} />
          </span>
          <span className="text-base font-semibold">
            jobys<span className="text-accent">.</span>
          </span>
        </a>

        <nav className="order-3 flex w-full items-center gap-5 border-t border-border pt-3 text-xs font-medium text-foreground/75 sm:order-0 sm:w-auto sm:border-0 sm:pt-0 sm:text-sm">
          <a className="transition-colors hover:text-accent" href="#jobs">
            Find jobs
          </a>
          <a className="transition-colors hover:text-accent" href="#companies">
            Companies
          </a>
          <a className="transition-colors hover:text-accent" href="#salary">
            Salary insights
          </a>
        </nav>

        <div className="flex items-center gap-2 sm:gap-4">
          <button
            type="button"
            onClick={toggleDarkMode}
            className="grid size-8 place-items-center rounded-full text-muted-foreground transition-colors hover:bg-muted hover:text-foreground"
            aria-label={
              isDarkMode ? "Switch to light mode" : "Switch to dark mode"
            }
          >
            {isDarkMode ? <Sun size={18} /> : <Moon size={18} />}
          </button>
          <a
            href="#login"
            className="hidden text-sm font-semibold text-foreground sm:block"
          >
            Sign in
          </a>
          <a
            href="#signup"
            className="bg-accent px-3.5 py-2 text-xs font-semibold text-accent-foreground transition-colors hover:bg-accent/90 sm:text-sm"
          >
            For employers
          </a>
        </div>
      </div>
    </header>
  );
}
